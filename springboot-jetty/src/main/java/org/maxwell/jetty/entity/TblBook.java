package org.maxwell.jetty.entity;


import lombok.Data;

@Data
public class TblBook {

  private long id;
  private String type;
  private String name;
  private String description;

}
