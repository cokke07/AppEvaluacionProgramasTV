package cl.cokke.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="users")
@SequenceGenerator(name = "SQ_USER", initialValue=1, allocationSize=1,sequenceName="SQ_USER")//NO COLOCAR EN MYSQL
public class User{
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long id;
	
	@Size(min =3,message = "Username must be present")
	private String username;
	@Size(min=5, message = "Email must be grater present and in a valid format")
	private String email;
	@Size(min=8, message = "Password must be greater than 8characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@OneToMany(mappedBy = "creatorShow", fetch = FetchType.LAZY)
	private List<Show> userShows;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Rating> ratings;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
}
