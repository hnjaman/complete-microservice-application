import { Injectable } from "@angular/core";
import { Product } from "./product.model";
import { Observable, from } from "rxjs";

@Injectable()
export class StaticDataSource {
    private products: Product[] = [
        new Product(1, "TW1", "Titan Watch", "titan.png", 20),
        new Product(2, "FTW1", "FastTrack watch", "fasttrack.png", null),
        new Product(3, "RW1", "Rolex Watch", "rolex.png", 10),
    ];

    getProducts(): Observable<Product[]> {
        return from([this.products]);
    }
}