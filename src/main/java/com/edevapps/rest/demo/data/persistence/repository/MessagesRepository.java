package com.edevapps.rest.demo.data.persistence.repository;

import com.edevapps.rest.demo.data.persistence.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends  JpaRepository<Message, Long> {
}
