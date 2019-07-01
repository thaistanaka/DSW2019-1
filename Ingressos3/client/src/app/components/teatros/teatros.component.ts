import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service'

@Component({
  selector: 'app-teatros',
  templateUrl: './teatros.component.html',
  styleUrls: ['./teatros.component.css']
})
export class TeatrosComponent implements OnInit {

  constructor(private api: ApiService) { }

  ngOnInit() {
  }

}
