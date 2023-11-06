package com.example.teladecadastro.model;

public class User {
    private String num_account;
    private String name;
    private String password;
    private String email;
    private String cpf;

    public User(String name, String password, String cpf, String email) {
        this.name = name;
        this.password = password;
        this.cpf = cpf;
        this.email = email;
    }

    public User() {
    }

    public String getNum_account() {
        return num_account;
    }

    public void setNum_account(String num_account) {
        this.num_account = num_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
