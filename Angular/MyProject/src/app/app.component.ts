import { Component } from '@angular/core';

@Component({ //Providing information about the class AppComponent
  selector: 'app-root', //Name given to the component
  templateUrl: './app.component.html', //HTML File
  styleUrls: ['./app.component.css'] //CSS File
})
export class AppComponent { //Additional information about the class
  title = 'MyProject';
  //Data binding
  strName : string = "My name is Riya Negi";

  //Event Binding
  button_call()
  {
    alert("Welcome to Angular & Bootstrap");
  }
  //Property Binding
  imageUrl : string ="./assets/Puppy.jpg";
}
