package com.sheet.work.time.table.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class TeamWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
