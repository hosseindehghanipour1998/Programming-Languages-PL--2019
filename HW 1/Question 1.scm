(display 'Welcome!)
(newline)

(define (isLeaf? x ) 
	(if (eqv? (car x ) 'leaf )#T #F) 


)

(define (isNode? x )
	(if (eqv? (car x ) 'node ) #T 
		#F
	)
)

(define (leftNode x )
	(if (null? (cadr x ) ) () 
		(cadr x )
	)
)

(define (rightNode x ) 
	(if (null? (cddr x ) ) ()
		(caddr x )
	)
)

(define (valueOf x )
	(cadr x )
)

(define (sum x)
	(cond 
		( (isLeaf? x ) (valueOf x ))
		( (isNode? x ) (+ (sum(leftNode x )) (sum(rightNode x )) ) )
	)
)

(define (main)
	(display 'Hossein_Dehghanipour_9532250)
	(newline)
	(display (sum '(node (leaf 1) (node (leaf 2) (leaf 3)))))
	(newline)
	(display (sum '(node (node (leaf 2) (leaf 3)) (node (node (leaf 4) (leaf 5))  (node (leaf 6) (leaf 7)) ))))
)

(main)
