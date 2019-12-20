; This Code is Written By : @alifarazz -> alifarazdaghi@gmail.com
(define (cdar ilist)
  (car (cdr ilist)))

;;;;;;;;;;;;;;;
;; Fibonacci ;;
;;;;;;;;;;;;;;;
(define (fib-recursive n)
  (cond ((= n 0) 0)
        ((= n 1) 1)
        (else
         (+ (fib-recursive (- n 1))
            (fib-recursive (- n 2))))))

(define (fib-iterative n)
  (define (fib-proc n a b)
    (if (= n 0)
        a
        (fib-proc (- n 1)
                  (+  a b)
                  a)))
  (fib-proc n 0 1))

;;;;;;;;;;;;;;;;;;;;
;; Flatten a list ;;
;;;;;;;;;;;;;;;;;;;;
(define (flatten ilist)
  (cond ((null? ilist) '())
        ((list? (car ilist)) (append (flatten (car ilist))
                                     (flatten (cdr ilist))))
        (else (cons (car ilist)
                    (flatten (cdr ilist))))))

(define (flatten-iter ilist)
  (define (flatten-proc ilist flat)
    (cond ((null? ilist) flat)
          ((list? (car ilist))
           (flatten-proc (cdr ilist)
                         (append (flatten-proc (car ilist) '())
                                 flat)))
          (else (flatten-proc (cdr ilist)
                              (cons (car ilist)
                                    flat)))))
  (reverse (flatten-proc ilist '())))

;; the built-in function is append
(define (concat a b)
  (define (concat-proc a b)
    (if (null? a)
        b
        (concat-proc (cdr a)
                     (cons (car a)
                           b))))
  (concat-proc (reverse a) b))

;;;;;;;;;;;;;;;;;;;;
;; map and reduce ;;
;;;;;;;;;;;;;;;;;;;;
(define (fold-right f ilist basis)
  (define (reduce-proc ilist res)
    (if (null? ilist)
        res
        (reduce-proc (cdr ilist)
                     (f (car ilist)
                        res))))
  (reduce-proc ilist basis))
(define reduce fold-right)

(define (map-example-basic)
  (map (lambda (x) (* 2 x))
       '(1 2 3)))
(define (map-example-first-elem)
  (map car
       '((1 2 3) (2 4 6) (3 6 9))))
(define (map-example-second-elem)
  (map cdar
       '((1 2 3) (2 4 6) (3 6 9))))

(define (mapreduce-sum-of-second-elems)
  (reduce + (map-example-second-elem) 0))

;; uv* procedure
(define (dot u v)
  (define (dot-proc u v res)
    (if (null? u)
        res
        (dot-proc (cdr u)
                  (cdr v)
                  (+ res
                     (* (car u)
                        (car v))))))
  (dot-proc u v 0))
;; If you want to go the mapreduce way,
;; you should first "zip" the two lists.
;; and then, reduce each pair within
;; the list with *. After that, reduce
;; the result with +.
(define (zip u v res)
  (if (null? u)
      res
      (zip (cdr u)
           (cdr v)
           (cons (cons (car u)
                       (car v))
                 res))))
(define (dot2 u v)
  (reduce +
          (map (lambda (p)
                 (* (car p) (cdr p)))
               (zip u v '()))
          0))

;; multiply a matrix by a vector
(define (mapreduce-mult-mat-by-vec-example)
  (define (multiply-matrix-by-vector mat vec)
    (map (lambda (x) (dot x vec))
         mat))
  (multiply-matrix-by-vector '((2 0 0 0)
                               (0 3 0 0)
                               (0 0 5 0)
                               (0 0 0 7))
                             '(1 1 1 1)))

(define (main)
  (define flat-example
    '(1 2 (1 2) ((1 2))))
  (define (display-example x)
    (display x)
    (newline))
  ;; main's body
  (map display-example
       (list "hello world"
             (fib-recursive 3)
             (fib-iterative 3)
             (flatten flat-example)
             (flatten-iter flat-example)
             (map-example-basic)
             (map-example-first-elem)
             (map-example-second-elem)
             (mapreduce-sum-of-second-elems)
             (mapreduce-mult-mat-by-vec-example)))
  0 ;; return 0
)
(main)
