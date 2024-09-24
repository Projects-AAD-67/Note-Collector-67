package lk.ijse.gdse.aad67.notecollecter67.controller;

import lk.ijse.gdse.aad67.notecollecter67.dto.impl.UserDTO;
import lk.ijse.gdse.aad67.notecollecter67.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
           @RequestPart ("firstName") String firstName,
           @RequestPart ("lastName") String lastName,
           @RequestPart ("email") String email,
           @RequestPart ("password") String password,
           @RequestPart ("profilePic") MultipartFile profilePic

    ) {
        System.out.println("RAW pro pic "+profilePic);
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
        //Todo: Build the Object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);

        return buildUserDTO;
    }
}