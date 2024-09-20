package com.example.registrationservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.registrationservice.Model.Registration;




public interface RegistrationRepo extends JpaRepository<Registration,Long> {

}
