package com.alibaba.dubbo.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * dubbo properties
 *
 * @author xionghui
 * @version 1.0.0
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "spring.dubbo")
public class DubboProperties {

  /**
   * dubbo application name
   */
  private String appname;

  /**
   * dubbo registry address
   */
  private String registry;

  /**
   * redis username
   */
  private String username;

  /**
   * redis password
   */
  private String password;

  /**
   * communication protocol, default is dubbo
   */
  private String protocol = "dubbo";

  /**
   * bind ip
   */
  private String host = "";

  /**
   * dubbo listen port, default 20800
   */
  private int port = 20800;

  /**
   * dubbo thread count, default 200
   */
  private int threads = 200;

  /**
   * dubbo version, may override by {@link com.alibaba.dubbo.config.annotation.Service#version
   * Service.version} or {@link com.alibaba.dubbo.config.annotation.Reference#version
   * Reference.version}
   */
  private String version = "";

  /**
   * dubbo group, may override by {@link com.alibaba.dubbo.config.annotation.Service#group
   * Service.group} or {@link com.alibaba.dubbo.config.annotation.Reference#group Reference.group}
   */
  private String group = "";

  public String getAppname() {
    return this.appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public String getRegistry() {
    return this.registry;
  }

  public void setRegistry(String registry) {
    this.registry = registry;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getProtocol() {
    return this.protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return this.port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public int getThreads() {
    return this.threads;
  }

  public void setThreads(int threads) {
    this.threads = threads;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getGroup() {
    return this.group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @Override
  public String toString() {
    return "DubboProperties [appname=" + this.appname + ", registry=" + this.registry
        + ", protocol=" + this.protocol + ", port=" + this.port + ", threads=" + this.threads
        + ", version=" + this.version + ", group=" + this.group + "]";
  }
}
