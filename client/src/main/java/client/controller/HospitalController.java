package client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//@RestController
@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String loginMessage(){
        return "welcome";
    }

    @RequestMapping(value = "/galust", method = RequestMethod.GET)
    public String galustnMessage(){
        return "galust.jsp";
    }

    @GetMapping("/register")
    public String showRegistrationPage(ModelMap model) {
        return "registerHospital";
    }

    @PostMapping("/register")
    public String registerNewHospital(ModelMap model, @RequestParam String name, @RequestParam String username,
                                      @RequestParam String password, @RequestParam String address,
                                      @RequestParam String email, @RequestParam String phone) {
//        restTemplate.postForEntity("http://localhost:8080/api/hospitals/register", );
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//        map.add("email", "first.last@example.com");
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );

        String url = "http://localhost:8080/api/hospitals/register";

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", name);
        map.add("username", username);
        map.add("password", password);
        map.add("address", address);
        map.add("email", email);
        map.add("phone", phone);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            model.put("name", name);
//            model.put("username", username);
//            model.put("password", password);
//            model.put("email", email);
//            model.put("phone", phone);
            return "registerHospitalComplete";
        } else {
            throw new RuntimeException("unexpected response from backend");
        }
    }
}

//         this.name = name;
//         this.username = username;
//         this.password = password;
//         this.address = address;
//         this.email = email;
//         this.phone = phone;