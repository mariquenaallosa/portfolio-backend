/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mariquena.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="skills_level")
    private int skillsLevel;
    
    @Column(name="nombre_skill")
    private String nombreSkill;
    
    @Column(name="img_skill")
    private String imgSkill;
    //Constructor

    public Skills() {
    }

    public Skills(int skillsLevel, String nombreSkill, String imgSkill) {
        this.skillsLevel = skillsLevel;
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
    }
    
    public Skills(int id, int skillsLevel, String nombreSkill, String imgSkill) {
        this.id = id;
        this.skillsLevel = skillsLevel;
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
    }

    
    
}
