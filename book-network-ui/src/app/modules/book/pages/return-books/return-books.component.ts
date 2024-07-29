import {Component, OnInit} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {PageResponseBorrowedBookResponse} from "../../../../services/models/page-response-borrowed-book-response";
import {BorrowedBookResponse} from "../../../../services/models/borrowed-book-response";
import {BookService} from "../../../../services/services/book.service";

@Component({
  selector: 'app-return-books',
  standalone: true,
    imports: [
        NgForOf,
        NgIf
    ],
  templateUrl: './return-books.component.html',
  styleUrl: './return-books.component.scss'
})
export class ReturnBooksComponent implements OnInit{
  returnedBooks: PageResponseBorrowedBookResponse = {};
  page: number = 0;
  size: number = 5;
  message: string = '';
  level: string = 'success';

  ngOnInit(): void {
    this.findAllReturnedBook();
  }

  constructor(
    private bookService: BookService) {
  }


  private findAllReturnedBook() {
    this.bookService.findAllReturnedBooks({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (resp) => {
        this.returnedBooks = resp;
      }
    })
  }

  goToFirstPage() {
    this.page = 0;
    this.findAllReturnedBook();
  }

  goToPreviousPage() {
    this.page--;
    this.findAllReturnedBook();
  }

  goToPage(page: number) {
    this.page = page;
    this.findAllReturnedBook();
  }

  goToNextPage() {
    this.page++;
    this.findAllReturnedBook();
  }

  goToLastPage() {
    this.page = this.returnedBooks.totalPages as number - 1;
    this.findAllReturnedBook();
  }

  get isLastPage(): boolean{
    return this.page == this.returnedBooks.totalPages as number - 1;
  }

  approveBookReturned(book: BorrowedBookResponse) {
    if(!book.returned){
      this.level = 'success';
      this.message = 'The book is not yet returned';
      return;
    }
    this.bookService.approveReturnBorrowBook({
      'book-id': book.id as number
    }).subscribe({
      next: () => {
        this.level = 'success';
        this.message = 'Book return approved successfully';
        this.findAllReturnedBook();
      }
    })
  }
}
