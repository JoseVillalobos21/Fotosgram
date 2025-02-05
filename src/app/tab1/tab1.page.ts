import { Component } from '@angular/core';
import { StoryViewComponent } from '../components/story-view/story-view.component';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: false,
})
export class Tab1Page {

   posts = [
    {
      username: "sophie_b",
      location: "London, UK",
      createAt: "2d",
      avatarUrl: "https://i.pravatar.cc/150?img=11",
      contentUrl: "https://picsum.photos/400/300?random=1",
      liked: false,
      saved: false,
      likes: 300,
      description: "Exploring the historic sites of London.",
      comments: 50,
    },
    {
      username: "nico_travels",
      location: "Barcelona, Spain",
      createAt: "Hace una hora",
      avatarUrl: "https://i.pravatar.cc/150?img=2",
      contentUrl: "https://picsum.photos/400/300?random=2",
      liked: false,
      saved: false,
      likes: 123,
      description: "Enjoying the vibrant culture in Barcelona.",
      comments: 25,
    },
    {
      username: "julia_k",
      location: "Santiago, Chile",
      createAt: "4d",
      avatarUrl: "https://i.pravatar.cc/150?img=3",
      contentUrl: "https://picsum.photos/400/300?random=3",
      liked: false,
      saved: false,
      likes: 67,
      description: "Exploring the beauty of Santiago.",
      comments: 15,
    },
    {
      username: "explorer_joe",
      location: "Beijing, China",
      createAt: "Hace 5 horas",
      avatarUrl: "https://i.pravatar.cc/150?img=4",
      contentUrl: "https://picsum.photos/400/300?random=4",
      liked: false,
      saved: false,
      likes: 280,
      description: "The Great Wall is a must-see!",
      comments: 40,
    },
    {
      username: "amelie_p",
      location: "Vienna, Austria",
      createAt: "5d",
      avatarUrl: "https://i.pravatar.cc/150?img=5",
      contentUrl: "https://picsum.photos/400/300?random=5",
      liked: false,
      saved: false,
      likes: 190,
      description: "Discovering the charming streets of Vienna.",
      comments: 35,
    },
    {
      username: "adventure_guru",
      location: "Melbourne, Australia",
      createAt: "Hace 10 minutos",
      avatarUrl: "https://i.pravatar.cc/150?img=6",
      contentUrl: "https://picsum.photos/400/300?random=6",
      liked: false,
      saved: false,
      likes: 75,
      description: "Amazing wildlife experiences in Melbourne.",
      comments: 10,
    },
    {
      username: "karla_90",
      location: "Hamburg, Germany",
      createAt: "1w",
      avatarUrl: "https://i.pravatar.cc/150?img=7",
      contentUrl: "https://picsum.photos/400/300?random=7",
      liked: false,
      saved: false,
      likes: 158,
      description: "Beautiful architecture in Hamburg.",
      comments: 20,
    },
    {
      username: "gourmet_guy",
      location: "Naples, Italy",
      createAt: "Hace 2 horas",
      avatarUrl: "https://i.pravatar.cc/150?img=8",
      contentUrl: "https://picsum.photos/400/300?random=8",
      liked: false,
      saved: false,
      likes: 220,
      description: "Best pizza in the world.",
      comments: 45,
    },
    {
      username: "pablo_explorer",
      location: "Cusco, Peru",
      createAt: "3d",
      avatarUrl: "https://i.pravatar.cc/150?img=9",
      contentUrl: "https://picsum.photos/400/300?random=9",
      liked: false,
      saved: false,
      likes: 310,
      description: "Incredible views of Machu Picchu.",
      comments: 70,
    },
    {
      username: "anna_v",
      location: "Montreal, Canada",
      createAt: "2w",
      avatarUrl: "https://i.pravatar.cc/150?img=10",
      contentUrl: "https://picsum.photos/400/300?random=10",
      liked: false,
      saved: false,
      likes: 98,
      description: "Charming cafes in Montreal.",
      comments: 12,
    },
    {
      username: "mike_c",
      location: "Cape Town, South Africa",
      createAt: "Hace 15 minutos",
      avatarUrl: "https://i.pravatar.cc/150?img=11",
      contentUrl: "https://picsum.photos/400/300?random=11",
      liked: false,
      saved: false,
      likes: 180,
      description: "Breathtaking sunsets by the ocean.",
      comments: 28,
    }
  ];
  
  trackByFn(index: number, post: any): number {
    return post.username; // Asume que cada post tiene un campo 'username' único.
  }
  
    // Función para abrir el modal con la historia
    async openStoryView(post: any) {
      const modal = await this.modalController.create({
        component: StoryViewComponent,
        componentProps: { 
          username: post.username,
          avatarUrl: post.avatarUrl,
          contentUrl: post.contentUrl,
        },
      });
      await modal.present();
    }
  
  constructor(private modalController: ModalController) {}

}
