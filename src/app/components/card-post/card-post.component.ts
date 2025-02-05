import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { ModalPostComponent } from '../modal-post/modal-post.component';

@Component({
  selector: 'app-card-post',
  templateUrl: './card-post.component.html',
  styleUrls: ['./card-post.component.scss'],
  standalone:false
})
export class CardPostComponent  implements OnInit {

  //Header
  @Input() username:string="";
  @Input() location:string="";
  @Input() createAt:string="";
  @Input() avatarUrl:string="";
  
  //Content
  @Input() contentUrl:string="";
  
  //Stats
  @Input() liked:boolean=false;
  @Input() saved:boolean=false;

  //Info
  @Input() likes:number=0;
  @Input() description:string="";
  @Input() comments:number=0;

  toggleLike() {
    this.liked = !this.liked;
    this.likes = this.liked ? this.likes + 1 : this.likes - 1;
  }

  // Función para cambiar el estado del ícono "bookmark"
  toggleSave() {
    this.saved = !this.saved;
  }
    constructor() {}

  ngOnInit() {}

}
