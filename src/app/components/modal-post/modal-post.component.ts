import { Component, Input , OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-modal-post',
  templateUrl: './modal-post.component.html',
  styleUrls: ['./modal-post.component.scss'],
  standalone:false
})
export class ModalPostComponent  implements OnInit {

  @Input() post: any;  // Recibimos el post que se quiere mostrar

  constructor(private modalController: ModalController) {}

   // Función para cerrar el modal
   dismiss() {
    this.modalController.dismiss();
  }

  
  ngOnInit() {}

}
