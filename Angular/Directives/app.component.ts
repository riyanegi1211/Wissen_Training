import { Component } from '@angular/core';

@Component({ //Providing information about the class AppComponent
  selector: 'app-root', //Name given to the component
  templateUrl: './app.component.html', //HTML File
  styleUrls: ['./app.component.css'] //CSS File
})
export class AppComponent { //Additional information about the class
  title = 'MyProject';
  bCustomer:boolean = true;
  
  changeToCustomer()
  {
    this.bCustomer = true;
  }
  changeToEmployee()
  {
    this.bCustomer = false;
  }
  strColor = "red";
  strFontSize = "10";
  strFontFam = 'Courier New';
  strBg = "blue";
  strMargin = "30";
  strAlign = "center";
  strOpacity = "0.2";
  strPadding = "5";

  userList = [
    {userId:101, name:"Neena",location:"Bangalore"},
    {userId:102, name:"Saurabh",location:"Mumbai"},
    {userId:103, name:"Tejas",location:"Pune"},
    {userId:104, name:"Mayuri",location:"Mumbai"},
    {userId:105, name:"Aashi",location:"Bangalore"}
  ];
  onEdit(obj:any)
  {
    this.userList = this.userList.filter((value,key)=>{
      if(value.userId == obj.userId){
        value.name = obj.name;
      }
      return true;
    });
  }
  
  onDelete(id:number)
  {
    this.userList = this.userList.filter((value , i) => i !==id);  
  }

  bLogin = true;
  bRegister = false;
  clickedLogin()
  {
    this.bLogin = true;
    this.bRegister = false;
  }
  clickedRegister()
  {
    this.bLogin = false;
    this.bRegister = true;
  }
}
