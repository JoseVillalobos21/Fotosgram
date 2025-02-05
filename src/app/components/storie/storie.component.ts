import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-storie',
  templateUrl: './storie.component.html',
  styleUrls: ['./storie.component.scss'],
  standalone:false
})
export class StorieComponent  implements OnInit {

  @Input() username:string="";
  @Input() avatarUrl:string="";
  

  constructor() { }

  ngOnInit() {}

}
