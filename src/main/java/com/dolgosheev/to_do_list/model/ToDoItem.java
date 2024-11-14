package com.dolgosheev.to_do_list.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ToDoItem {

    @Id
    @GeneratedValue
    Long id;
    String title;

}
