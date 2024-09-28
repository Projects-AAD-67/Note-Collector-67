package lk.ijse.gdse.aad67.notecollecter67.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad67.notecollecter67.dao.UserDao;
import lk.ijse.gdse.aad67.notecollecter67.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollecter67.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
       userDao.save()
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }
}
