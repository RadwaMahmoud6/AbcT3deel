
package com.example.demo.controller;
  
import java.util.Collection; 
import java.util.List;
import org.springframework.security.core.GrantedAuthority; 
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.entities.CustomerEntity;
import lombok.Getter; 
import lombok.Setter;
  
  
  @SuppressWarnings("serial")
  @Getter
  @Setter
  public class CustomerDetails implements UserDetails {
  
  
  private String userName;
  private String userPassword;
  private boolean active;
  private List<GrantedAuthority>authorities;
  
  
  
  public CustomerDetails(CustomerEntity custent)
  { 
	  this.userName = custent.getUserName();
	  this.userPassword = custent.getUserPassword();
  }
  
  
  @Override 
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
	  return authorities;
  }
  
  
  @Override
  public String getPassword() { return userPassword; }
  
  
  @Override
  public String getUsername() 
  { 
	  return userName; 
  }
  
  
  @Override public boolean isAccountNonExpired()
  { 
	  return true; 
  }
  
  
  @Override public boolean isAccountNonLocked() { return true; }
  
  
  @Override public boolean isCredentialsNonExpired() { return true; }
  
  
  @Override public boolean isEnabled() { return true; }
  
  
  
  }
 