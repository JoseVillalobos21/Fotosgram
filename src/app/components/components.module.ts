import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { IonicModule } from '@ionic/angular';
import { CardPostComponent } from './card-post/card-post.component';
import { StorieComponent } from './storie/storie.component';
import { ModalPostComponent } from './modal-post/modal-post.component';
import { StoryViewComponent } from './story-view/story-view.component';


@NgModule({
  declarations: [
    LayoutComponent,
    CardPostComponent,
    StorieComponent,
    ModalPostComponent,
    StoryViewComponent
  ],
  imports: [
    IonicModule,
    CommonModule
  ],
  exports:[
    LayoutComponent,
    CardPostComponent,
    StorieComponent,
    ModalPostComponent,
    StoryViewComponent
  ]
})
export class ComponentsModule { }
