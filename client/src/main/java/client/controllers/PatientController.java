package client.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import commons.entities.Patient;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping//(path = "/client/v1")
public class PatientController {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    final OkHttpClient http;


    @Autowired
    public PatientController(OkHttpClient http) {
        this.http = http;
    }

    @GetMapping("/signUp")
    public String showRegistrationPage(Model model) {
        model.addAttribute("patientForm", new Patient());
        return "signUp";
    }

    //    (Map<String, Object> model,  BindingResult bindingResult,@RequestParam String username, @RequestParam String firstName,
//    @RequestParam String lastName, @RequestParam String password,
//    @RequestParam String passwordConfirmation, @RequestParam String email)
    @PostMapping("/signUp")
    public String showLoginPage(@ModelAttribute("patientForm") @Valid Patient patient, BindingResult bindingResult, Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(patient);
//
//        RequestBody body = RequestBody.create(JSON, json);
        RequestBody body = new FormBody.Builder()
                .add("username", patient.getUsername())
                .add("firstName", patient.getFirstName())
                .add("lastName", patient.getLastName())
                .add("password", patient.getPassword())
                .add("passwordConfirmation", patient.getPasswordConfirmation())
                .add("email", patient.getEmail())
                .build();


        String url = "http://localhost:9005/signUp";
        Request request = new Request.Builder()
                .url(url)
                .post(body)
//                .addHeader("username", patient.getUsername())
//                .addHeader("username", patient.getUsername())
//                .addHeader("firstName", patient.getFirstName())
//                .addHeader("lastName", patient.getLastName())
//                .addHeader("password", patient.getPassword())
//                .addHeader("passwordConfirmation", patient.getPasswordConfirmation())
//                .addHeader("email", patient.getEmail())
                .build();
//                .newBuilder()
//                .addQueryParameter("username", patient.getUsername())
//                .addQueryParameter("firstName", patient.getFirstName())
//                .addQueryParameter("lastName", patient.getLastName())
//                .addQueryParameter("password", patient.getPassword())
//                .addQueryParameter("passwordConfirmation", patient.getPasswordConfirmation())
//                .addQueryParameter("email", patient.getEmail())
//                .build().toString();


        try (Response response = http.newCall(request).execute()) {
            if (response.code() == 200) {
//                if (!response.body().equals("null")) {
//                String s = response.body().string();
//                ResponseEntity responseEntity = mapper.readValue(s, ResponseEntity.class);
//                model.addAttribute("message", responseEntity);
                return "login";
            } else
                model.addAttribute("errorMessage", response.message());
            return "signUp";
//            } else {
//                throw new RuntimeException("unexpected response from backend : request = " + request + ", response = " + response);
//            }
        }

    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

}

