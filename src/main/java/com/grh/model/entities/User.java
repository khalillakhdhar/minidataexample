package com.grh.model.entities;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class User extends BaseEntity {
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false,unique = true)
	private String telephone;
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnoreProperties("user")
	private Profile profile;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnoreProperties("user")
	
	private List<Taches> taches;
	

}
