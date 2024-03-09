package com.grh.dao.services;

import java.util.List;
import java.util.Optional;

import com.grh.model.entities.Profile;
import com.grh.model.entities.User;

public interface UserServiceInterface {
	public List<User> getUsers();
	public Optional<User> getOneUser(long id);
	public User creaOneUser(User user);
	public void deleteOneUser(long id);
	public User AssignProfileToUser(long Userid,Profile profile);
	public Profile updateProfile(Profile profile, long userId);
	

}
