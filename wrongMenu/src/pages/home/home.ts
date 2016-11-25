import { Component } from '@angular/core';
import { EmailValidator } from '../../validators/email';
import { NavController, LoadingController, AlertController } from 'ionic-angular';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage
{
  loginForm: any;
  emailChanged: boolean = false;
  passwordChanged: boolean = false;
  submitAttempt: boolean = false;
  loading: any;

  constructor(public nav: NavController, public formBuilder: FormBuilder,
  public alertCtrl: AlertController, public loadingCtrl: LoadingController)
  {
    this.loginForm = formBuilder.group({
      email: ['', Validators.compose([Validators.required, EmailValidator.isValid])],
      password: ['', Validators.compose([Validators.required,Validators.minLength(6)])]
    });
  }

  goToResetPassword()
  {
    console.log('Remember password');
  }

  createAccount()
  {
    console.log('Create new User');
  }

  elementChanged(input)
  {
    console.log('input: '+input);
    console.log('field: '+input.inputControl.name);
    let field = input.inputControl.name;
    this[field + "Changed"] = true;
  }

  loginButton()
  {
    console.log('login User function');
  }
}
