import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-story-view',
  templateUrl: './story-view.component.html',
  styleUrls: ['./story-view.component.scss'],
  standalone:false
})
export class StoryViewComponent {
  @Input() username: string = '';
  @Input() avatarUrl: string = '';
  @Input() contentUrl: string = '';  // Contenido de la historia (imagen o video)

  constructor() {}
}
