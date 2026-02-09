package com.example.networkmodule.models;

import android.icu.number.IntegerWidth;

public class Project {
    public Integer idType;
    public String name;
    public String description;
    public String sartDate;
    public String endDate;
    public Integer idCategory;
    public Project(){}
    public Project(Integer idType, String name, String description, String sartDate, String endDate, Integer idCategory){
        this.idType = idType;
        this.name = name;
        this.description = description;
        this.sartDate = sartDate;
        this.endDate = endDate;
        this.idCategory = idCategory;
    }
}
