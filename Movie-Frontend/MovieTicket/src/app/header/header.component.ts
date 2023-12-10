import { Component ,OnInit, EventEmitter,Output} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  ngOnInit(): void {
   
  }
  public searchItem:string='';


  @Output()
  searchTextChanged:EventEmitter<string>= new EventEmitter <string>();

  onSearchTextChanged()
{
  this.searchTextChanged.emit(this.searchItem)
}

}
