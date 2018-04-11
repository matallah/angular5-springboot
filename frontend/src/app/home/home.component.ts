import {Component, OnInit} from '@angular/core';
import {
  FooService,
  ConfigService,
  UserService
} from '../service';
import {SelectItem} from "primeng/api";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  fooResponse = {};
  whoamIResponse = {};
  allUserResponse = {};

  constructor(private config: ConfigService,
              private fooService: FooService,
              private userService: UserService) {
    // SelectItem API with label-value pairs
    this.cities1 = [
      {label: 'Select City', value: null},
      {label: 'New York', value: {id: 1, name: 'New York', code: 'NY'}},
      {label: 'Rome', value: {id: 2, name: 'Rome', code: 'RM'}},
      {label: 'London', value: {id: 3, name: 'London', code: 'LDN'}},
      {label: 'Istanbul', value: {id: 4, name: 'Istanbul', code: 'IST'}},
      {label: 'Paris', value: {id: 5, name: 'Paris', code: 'PRS'}}
    ];

    //An array of cities
    this.cities2 = [
      {name: 'New York', code: 'NY'},
      {name: 'Rome', code: 'RM'},
      {name: 'London', code: 'LDN'},
      {name: 'Istanbul', code: 'IST'},
      {name: 'Paris', code: 'PRS'}
    ];
  }

  ngOnInit() {
  }

  makeRequest(path) {
    if (path === this.config.foo_url) {
      this.fooService.getFoo()
        .subscribe(res => {
          this.forgeResonseObj(this.fooResponse, res, path);
        }, err => {
          this.forgeResonseObj(this.fooResponse, err, path);
        });
    } else if (path === this.config.whoami_url) {
      this.userService.getMyInfo()
        .subscribe(res => {
          this.forgeResonseObj(this.whoamIResponse, res, path);
        }, err => {
          this.forgeResonseObj(this.whoamIResponse, err, path);
        });
    } else {
      this.userService.getAll()
        .subscribe(res => {
          this.forgeResonseObj(this.allUserResponse, res, path);
        }, err => {
          this.forgeResonseObj(this.allUserResponse, err, path);
        });
    }
  }

  forgeResonseObj(obj, res, path) {
    obj['path'] = path;
    obj['method'] = 'GET';
    if (res.ok === false) {
      // err
      obj['status'] = res.status;
      try {
        obj['body'] = JSON.stringify(JSON.parse(res._body), null, 2);
      } catch (err) {
        console.log(res);
        obj['body'] = res.error.message;
      }
    } else {
      // 200
      obj['status'] = 200;
      obj['body'] = JSON.stringify(res, null, 2);
    }
  }

  cities1: SelectItem[];

  cities2: City[];

  selectedCity1: City;

  selectedCity2: City;

}

interface City {
  name: string;
  code: string;
}
