package com.portfolio.mariquena.Dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkills {
    @NotNull
    private int skillsLevel;
    @NotNull
    private String nombreSkill;
    @NotNull
    private String imgSkill;

    public dtoSkills(int skillsLevel, String nombreSkill, String imgSkill) {
        this.skillsLevel = skillsLevel;
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
    }
    
    
    
}
