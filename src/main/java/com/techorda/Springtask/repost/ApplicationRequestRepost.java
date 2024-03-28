package com.techorda.Springtask.repost;

import com.techorda.Springtask.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRequestRepost extends JpaRepository <ApplicationRequest,Long>{
}
