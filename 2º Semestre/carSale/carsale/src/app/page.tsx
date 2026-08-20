import { DialogLogin } from "@/components/ui/dialog-login";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Button } from "@/components/ui/button";
import { fetchCars } from "./actions/car-actions";
import Link from "next/link";


export default async function Home() {

  const cars = await fetchCars()

  return (
    <main className="flex min-h-screen flex-col items-center p-24 gap-8">

      <nav className="absolute top-2 right-2">
        <DialogLogin />
      </nav>

      <h1 className="text-4xl font-bold">Car Sale</h1>

      <p className="text-lg">
        Descubra os melhores carros do mundo e participe com os seus comentários
      </p>

      <section className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {cars.map((car: Car) => (
          <Card className="flex flex-col">
            <CardHeader>
              <img className="w-full h-[200px] object-cover" src={car.imageUrl} alt={car.model} />
              <CardTitle>{car.model}</CardTitle>
              <CardDescription>{car.brand}</CardDescription>
            </CardHeader>
            <CardContent className="flex-grow">
              <p>{car.description}</p>
            </CardContent>
            <CardFooter className="mt-auto">
              <Link href={`/details/${car.id}`} className="w-full">
                <Button className="w-full">Ver mais</Button>
              </Link>
            </CardFooter>
          </Card>
        ))}
      </section>


    </main>
  );
}
