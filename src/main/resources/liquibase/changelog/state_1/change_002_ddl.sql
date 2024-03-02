-- CREATE Table: tourist_packages_destinations

CREATE TABLE IF NOT EXISTS public.tourist_packages_destinations (
    tourist_package_id INT,
    reservation_id INT,
    CONSTRAINT fk_core_type
        FOREIGN KEY (tourist_package_id) REFERENCES public.tourist_package(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_core_status_contact
        FOREIGN KEY (reservation_id) REFERENCES public.reserva(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);