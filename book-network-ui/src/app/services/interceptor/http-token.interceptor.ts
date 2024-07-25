import { HttpInterceptorFn } from '@angular/common/http';
import {inject} from "@angular/core";
import {TokenService} from "../token/token.service";

export const httpTokenInterceptor: HttpInterceptorFn = (req, next) => {
  const tokenService = inject(TokenService);
  const token = tokenService.token;
  console.log('Token:', token);

  if (token) {
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
    console.log('Request with Auth:', authReq); // Debug: afficher la requête clonée
    return next(authReq);
  }
  return next(req);
};
