package main

import (
	"fmt"
)

func main() {
	var n int
	fmt.Scan(&n)

	min := -1
	for i := 0; i < n; i++ {
		var a int
		fmt.Scan(&a)

		count := 0
		for a != 0 && a%2 == 0 {
			count++
			a = a / 2
		}

		if min == -1 || count < min {
			min = count
		}
	}
	fmt.Println(min)
}
