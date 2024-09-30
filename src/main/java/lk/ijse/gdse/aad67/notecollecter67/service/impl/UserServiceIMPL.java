package lk.ijse.gdse.aad67.notecollecter67.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad67.notecollecter67.dao.UserDao;
import lk.ijse.gdse.aad67.notecollecter67.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollecter67.entity.impl.UserEntity;
import lk.ijse.gdse.aad67.notecollecter67.exception.DataPersistException;
import lk.ijse.gdse.aad67.notecollecter67.service.UserService;
import lk.ijse.gdse.aad67.notecollecter67.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser =
                userDao.save(mapping.toUserEntity(userDTO));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userDao.findAll();
        return mapping.asUserDTOList(allUsers);
    }

    @Override
    public UserDTO getUser(String userId) {
        UserEntity selectedUser = userDao.getReferenceById(userId);
        return mapping.toUserDTO(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteById(userId);
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }
}
