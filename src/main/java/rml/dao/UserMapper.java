package rml.dao;

import rml.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}