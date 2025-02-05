import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-post',
  templateUrl: './card-post.component.html',
  styleUrls: ['./card-post.component.scss'],
  standalone: false
})
export class CardPostComponent  implements OnInit {
  //header
  @Input() username:string = '';
  @Input() location:string = '';
  @Input() avatarUrl:string = '';
  @Input() createdAt:string = '';
  //stats
  @Input() liked:boolean = false;
  @Input() saved:boolean = false;
  
  //info
  @Input() likes:number = 0;
  @Input() description:string = '';

  constructor() { }

  ngOnInit() {}

}
