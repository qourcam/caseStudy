package com.gorkem.caseStudy.dao;

import lombok.Getter;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Getter
public class StartEndTimeDAO {

    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;

}
