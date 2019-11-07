package com.myicecream.scs_mobile;

public class AddGroupAdapter {
    private String groupName;
    private String groupMembers;
    private String description;

    public  AddGroupAdapter(String id, String groupName, String groupMembers, String description){
        this.groupName= groupName;
        this.groupMembers=groupMembers;
        this.description = description;
    }

    public String getGroupName(){
        return groupName;
    }
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
    public String getGroupMembers(){
        return groupMembers;
    }
    public void setGroupMembers(String groupMembers){
        this.groupMembers = groupMembers;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }
}
