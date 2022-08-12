package com.proj.gps.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.gps.dtos.RoleDTO;
import com.proj.gps.dtos.UserDTO;
import com.proj.gps.dtos.UserInsertDTO;
import com.proj.gps.dtos.UserUpdateDTO;
import com.proj.gps.entities.Role;
import com.proj.gps.entities.User;
import com.proj.gps.repositories.RoleRepository;
import com.proj.gps.repositories.UserRepository;
import com.proj.gps.services.exceptions.DatabaseException;
import com.proj.gps.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(final Pageable pageable) {
		final Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(final Long id) {
		final Optional<User> obj = this.repository.findById(id);
		final User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(final UserInsertDTO dto) {
		User entity = new User();
		this.copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = this.repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(final Long id, final UserUpdateDTO dto) {
		try {
			User entity = this.repository.getOne(id);
			this.copyDtoToEntity(dto, entity);
			entity = this.repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		}
	}

	public void delete(final Long id) {
		try {
			this.repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final User user = repository.findByEmail(username);

		if (user == null) {
			logger.error("User not found : " + username);
			throw new UsernameNotFoundException("Email not found");
		}

		logger.info("User found : " + username);

		return user;
	}

	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());

		entity.getRoles().clear();

		for (RoleDTO roleDto : dto.getRoles()) {
			final Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
	}

}
