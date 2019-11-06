package com.myicecream.scs_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import java.util.List;

public class addGroup extends ArrayAdapter<AddGroupAdapter> {
    private Context context;
    private List<AddGroupAdapter> members;


    public addGroup(Context context, List<AddGroupAdapter> members) {
        super(context,R.layout.display);
        this.context= context;
        this.members=members;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View group = LayoutInflater.from(parent.getContext()).inflate(R.layout.display,parent,false);

        EditText  editTextName=(EditText) group.findViewById(R.id.groupName);
        EditText  editTextMember=(EditText) group.findViewById(R.id.members);
        AddGroupAdapter add= members.get(position);

        editTextName.setText(add.getGroupName());
        editTextMember.setText(add.getGroupMembers());
        return group;
    }
}
