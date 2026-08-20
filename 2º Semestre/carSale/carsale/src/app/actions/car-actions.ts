"use server"

export async function fetchCars(){
    const response = await fetch("http://localhost:8080/cars", {
        cache: 'no-store'
    })
    const cars = await response.json()
    return cars
}

export async function fetchCarById(id: string){
    const response = await fetch(`http://localhost:8080/cars/${id}`, {
        cache: 'no-store'
    })
    const car = await response.json()
    return car
}