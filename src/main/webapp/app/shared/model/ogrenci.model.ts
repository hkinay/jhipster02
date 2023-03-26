import dayjs from 'dayjs';
import { ISinif } from 'app/shared/model/sinif.model';

export interface IOgrenci {
  id?: number;
  adiSoyadi?: string | null;
  ogrNo?: number | null;
  cinsiyeti?: boolean | null;
  dogumTarihi?: string | null;
  sinifs?: ISinif[] | null;
}

export const defaultValue: Readonly<IOgrenci> = {
  cinsiyeti: false,
};
