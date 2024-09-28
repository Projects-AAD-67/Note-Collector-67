package lk.ijse.gdse.aad67.notecollecter67.controller;

import lk.ijse.gdse.aad67.notecollecter67.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollecter67.service.UserService;
import lk.ijse.gdse.aad67.notecollecter67.service.impl.UserServiceIMPL;
import lk.ijse.gdse.aad67.notecollecter67.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
           @RequestPart ("firstName") String firstName,
           @RequestPart ("lastName") String lastName,
           @RequestPart ("email") String email,
           @RequestPart ("password") String password,
           @RequestPart ("profilePic") MultipartFile profilePic
    ) {
         // profilePic ----> Base64
        String base64ProPic = "";
        try {
            byte [] bytesProPic = profilePic.getBytes();
            base64ProPic = AppUtil.profilePicToBase64(bytesProPic);
        }catch (Exception e){
            e.printStackTrace();
        }
        //UserId generate
        String userId = AppUtil.generateUserId();
        //Build the Object
        UserDTO buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        userService.saveUser(buildUserDTO);
        return buildUserDTO;
    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable ("userId") String userId){
        return userService.getUser(userId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
       return userService.getAllUsers();
    }


}
