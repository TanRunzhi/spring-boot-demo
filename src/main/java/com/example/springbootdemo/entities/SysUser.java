package com.example.springbootdemo.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_CORE_USER")
@Getter
@Setter
@ToString
public class SysUser {

  @Id
  @Column (name = "pid")
  @GeneratedValue (generator = "hibernate-uuid")
  @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
  private String id;

  private Boolean flag = true;

  @ManyToOne()
  @JoinColumn(name = "updater")
  private SysUser updater;

  private String account;

  @Column(name = "real_name")
  private String realName;

  private String pwd;

  private String phone;

  private String mail;

  private String type;

  @Transient
  private String option;

  /**
   * 解锁时间 (若帐号被锁住则有值，若帐号未被锁住则为null)
   * */
  @Column(name = "unlock_time")
  private Date unlockTime;

  /**
   * 用户登录错误次数
   * */
  @Column(name = "login_failed_times")
  private Integer loginFailedTimes = 0;

  @Column(name = "last_login_time")
  private Date lastLoginTime;

  @Column(name = "last_login_ip")
  private String lastLoginIp;


  public SysUser() {
  }

}