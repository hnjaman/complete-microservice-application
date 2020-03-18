import { Component, OnInit } from "@angular/core";
import { ProductRepository } from '../model/product.repository';
import { Product } from '../model/product.model';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
    selector: "store",
    templateUrl: "store.component.html",
    styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

    private products:any;

    private productsUrl = 'http://localhost:8081/products';

    constructor(
        private repository: ProductRepository,
        private http: HttpClient) { }

    ngOnInit(): void {
        this.getproducts();
    }
    
    getproducts() {
        console.log("product api call")
        return this.http
        .get<any[]>(this.productsUrl)
        .pipe(map(data => data)).subscribe(products => {
            this.products = products;
            console.log(this.products);
        })
    }

    getcategories(): string[] {
        return this.repository.getCategories();
    }
}