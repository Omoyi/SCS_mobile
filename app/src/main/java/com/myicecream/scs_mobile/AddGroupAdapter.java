package com.myicecream.scs_mobile;

public class AddGroupAdapter {
    private String groupName;
    private String groupMembers;
    private String password;
    private String confirmPassword;

    public  AddGroupAdapter(String groupName,String groupMembers,String password, String confirmPassword){
        this.groupName= groupName;
        this.groupMembers=groupMembers;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getGroupName(){
        return groupName;
    }
    public String getGroupMembers(){
        return groupMembers;
    }
    public String getPassword(){
        return password;
    }
    public String getConfirmPassword(){
        return confirmPassword;
    }
}
