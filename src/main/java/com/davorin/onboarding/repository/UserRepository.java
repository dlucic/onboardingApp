package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();
}
