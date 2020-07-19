package com.system.springboot.backend.entity;




import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String surname;

	private String address;

	private String email;

	private String telephone;

	private String image;

	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Course> course;

	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Role> role;

	@JsonIgnoreProperties(value = { "user", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserDetail> userDetail;

}
